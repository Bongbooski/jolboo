import urllib.request
import ssl
import zipfile
import os
import pandas as pd
import pymysql

base_dir = os.getcwd()


def kospi_master_download(base_dir, verbose=False):
    cwd = os.getcwd()
    if (verbose):
        print(f"current directory is {cwd}")
    ssl._create_default_https_context = ssl._create_unverified_context

    urllib.request.urlretrieve("https://new.real.download.dws.co.kr/common/master/kospi_code.mst.zip",
                               base_dir + "\\kospi_code.zip")

    os.chdir(base_dir)
    if (verbose):
        print(f"change directory to {base_dir}")
    kospi_zip = zipfile.ZipFile('kospi_code.zip')
    kospi_zip.extractall()

    kospi_zip.close()

    if os.path.exists("kospi_code.zip"):
        os.remove("kospi_code.zip")


def kosdaq_master_download(base_dir, verbose=False):
    cwd = os.getcwd()
    if (verbose):
        print(f"current directory is {cwd}")
    ssl._create_default_https_context = ssl._create_unverified_context

    urllib.request.urlretrieve("https://new.real.download.dws.co.kr/common/master/kosdaq_code.mst.zip",
                               base_dir + "\\kosdaq_code.zip")

    os.chdir(base_dir)
    if (verbose):
        print(f"change directory to {base_dir}")
    kosdaq_zip = zipfile.ZipFile('kosdaq_code.zip')
    kosdaq_zip.extractall()

    kosdaq_zip.close()

    if os.path.exists("kosdaq_code.zip"):
        os.remove("kosdaq_code.zip")


def get_kospi_master_dataframe(base_dir):
    con = pymysql.connect(host='localhost', user='root',
                          password='jolboo2022', database='jolboo', charset='utf8')

    deleteSql = "delete from stock_items"
    cur = con.cursor()
    cur.execute(deleteSql)
    con.commit()

    sql = "insert into stock_items values(%s, %s, %s)"

    file_name = base_dir + "\\kospi_code.mst"

    with open(file_name, mode="r", encoding="cp949") as f:
        for row in f:
            rf1 = row[0:len(row) - 228]
            rf1_1 = rf1[0:9].rstrip()

            rf1_2 = rf1[9:21].rstrip()
            rf1_3 = rf1[21:].strip()
            if row[-228:-226] == 'ST':
                vals = (rf1_1, rf1_3, 'KOSPI')
                cur = con.cursor()
                cur.execute(sql, vals)
                con.commit()

    con.close()


def get_kosdaq_master_dataframe(base_dir):
    con = pymysql.connect(host='localhost', user='root',
                          password='jolboo2022', database='jolboo', charset='utf8')

    sql = "insert into stock_items values(%s, %s, %s)"

    file_name = base_dir + "\\kosdaq_code.mst"

    with open(file_name, mode="r", encoding="cp949") as f:
        for row in f:
            rf1 = row[0:len(row) - 228]
            rf1_1 = rf1[0:9].rstrip()
            rf1_3 = rf1[21:].strip()

            vals = (rf1_1, rf1_3, 'KOSDAQ')
            cur = con.cursor()
            cur.execute(sql, vals)
            con.commit()

    con.close()


kospi_master_download(base_dir)
get_kospi_master_dataframe(base_dir)

kosdaq_master_download(base_dir)
get_kosdaq_master_dataframe(base_dir)
