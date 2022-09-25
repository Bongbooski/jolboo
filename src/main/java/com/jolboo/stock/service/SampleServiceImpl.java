package com.jolboo.stock.service;

import com.jolboo.stock.config.AccessToken;
import com.jolboo.stock.dto.*;
import com.jolboo.stock.feign.StockFeign;
import com.jolboo.stock.feign.StockOauthFeign;
import com.jolboo.stock.model.OauthVO;
import com.jolboo.stock.repository.OauthRepository;
import com.jolboo.stock.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
    private final StockFeign stockFeign;
    private final StockOauthFeign stockOauthFeign;
    private final SampleRepository sampleRepository;

    private final AccessToken accessToken;

    private final OauthRepository oauthRepository;

    @Value("${app.oauth.appkey}")
    private String appKey;
    @Value("${app.oauth.appsecret}")
    private String appSecret;
    private final String cano = "50070822";

    private final String grantType = "client_credentials";

    public HashResponseDTO retrieveSample() {

        HashRequestDTO hashRequestDTO = HashRequestDTO.builder()
                .ORD_PRCS_DVSN_CD("02")
                .CANO(cano)
                .ACNT_PRDT_CD("03")
                .SLL_BUY_DVSN_CD("02")
                .SHTN_PDNO("101S06")
                .ORD_QTY("1")
                .UNIT_PRICE("370")
                .NMPR_TYPE_CD("")
                .KRX_NMPR_CNDT_CD("")
                .CTAC_TLNO("1")
                .FUOP_ITEM_DVSN_CD("")
                .ORD_DVSN_CD("02")
                .build();
        HashResponseDTO result = stockOauthFeign.getHashKey(appKey, appSecret, hashRequestDTO);

        sampleRepository.findById(1);

        accessToken.setHashKey(result.getHASH());
        return result;
    }

    public void setAccessToken() {
        String today = OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMd"));
        Optional<OauthVO> byIssuedDate = oauthRepository.findByIssuedDate(today);

        if (byIssuedDate.isEmpty()) {
            AccessTokenResponseDTO client_credentials = stockOauthFeign.getAccessToken(AccessTokenRequestDTO.builder()
                    .grant_type("client_credentials")
                    .appkey(appKey)
                    .appsecret(appSecret)
                    .build());
            OauthVO oauth = OauthVO.builder()
                    .issuedDate(today)
                    .accessToken(client_credentials.getToken_type() + " " + client_credentials.getAccess_token())
                    .expiredDatetime(OffsetDateTime.parse(client_credentials.getAccess_token_token_expired(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC)))
                    .build();
            oauthRepository.save(oauth);
            accessToken.setAccessToken(client_credentials.getToken_type() + " " + client_credentials.getAccess_token());
        } else {
            accessToken.setAccessToken(byIssuedDate.get().getAccessToken());
        }

//        stockFeign.getInquirePrice("J", "000660");
    }

    public String getAuthorization() {
        HashRequestDTO hashRequestDTO = HashRequestDTO.builder()
                .ORD_PRCS_DVSN_CD("02")
                .CANO(cano)
                .ACNT_PRDT_CD("03")
                .SLL_BUY_DVSN_CD("02")
                .SHTN_PDNO("101S06")
                .ORD_QTY("1")
                .UNIT_PRICE("370")
                .NMPR_TYPE_CD("")
                .KRX_NMPR_CNDT_CD("")
                .CTAC_TLNO("1")
                .FUOP_ITEM_DVSN_CD("")
                .ORD_DVSN_CD("02")
                .build();
        HashResponseDTO result = stockOauthFeign.getHashKey(appKey, appSecret, hashRequestDTO);
        return result.getHASH();
    }

    private void setRequestHeader(String trId) {
        setAccessToken();
        accessToken.setTrId(trId);
    }

    public VtsGetBalanceResponseDTO getVtsGetBalance() {
        setRequestHeader("VTTC8434R");

        VtsGetBalanceRequestParamDTO requestParamDTO = VtsGetBalanceRequestParamDTO.builder()
                .CANO(cano)
                .ACNT_PRDT_CD("01")
                .AFHR_FLPR_YN("N")
                .OFL_YN("")
                .INQR_DVSN("01")
                .UNPR_DVSN("01")
                .FUND_STTL_ICLD_YN("N")
                .FNCG_AMT_AUTO_RDPT_YN("N")
                .PRCS_DVSN("00")
                .CTX_AREA_NK100("")
                .CTX_AREA_FK100("")
                .build();
        VtsGetBalanceResponseDTO result = stockFeign.getVtsBalance(requestParamDTO.getCANO(), requestParamDTO.getACNT_PRDT_CD(),requestParamDTO.getAFHR_FLPR_YN(), requestParamDTO.getOFL_YN(), requestParamDTO.getINQR_DVSN(), requestParamDTO.getUNPR_DVSN(), requestParamDTO.getFUND_STTL_ICLD_YN(), requestParamDTO.getFNCG_AMT_AUTO_RDPT_YN(), requestParamDTO.getPRCS_DVSN(), requestParamDTO.getCTX_AREA_FK100(), requestParamDTO.getCTX_AREA_NK100() );
        return result;
    }
}