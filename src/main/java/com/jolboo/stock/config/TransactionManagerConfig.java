package com.jolboo.stock.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.jolboo.stock.repository"})
public class TransactionManagerConfig {}
