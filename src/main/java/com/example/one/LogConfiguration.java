package com.example.one;

import com.tosan.http.server.starter.filter.HttpLoggingFilter;
import com.tosan.http.server.starter.filter.HttpStatisticsFilter;
import com.tosan.http.server.starter.util.HttpLogUtil;
import com.tosan.tools.mask.starter.config.SecureParameter;
import com.tosan.tools.mask.starter.config.SecureParametersConfig;
import com.tosan.tools.mask.starter.configuration.MaskBeanConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.tosan.http.server.starter.util.Constants.AUTHORIZATION_SECURE_PARAM;
import static com.tosan.http.server.starter.util.Constants.PROXY_AUTHORIZATION_SECURE_PARAM;

/**
 * @author mina khoshnevisan
 * @since 7/13/2022
 */
@Configuration
public class LogConfiguration {

    @Bean("http-server-util-secured-parameters")
    public SecureParametersConfig secureParametersConfig() {
        Set<SecureParameter> securedParameters = MaskBeanConfiguration.SECURED_PARAMETERS;
        securedParameters.add(AUTHORIZATION_SECURE_PARAM);
        securedParameters.add(PROXY_AUTHORIZATION_SECURE_PARAM);
        return new SecureParametersConfig(securedParameters);
    }

    @Bean
    public HttpStatisticsFilter httpStatisticsFilter() {
        HttpStatisticsFilter httpStatisticsFilter = new HttpStatisticsFilter();
        httpStatisticsFilter.addExcludeUrlPatterns(Collections.singletonList("/testUrl"));
        return httpStatisticsFilter;
    }

    @Bean
    public HttpLoggingFilter httpLoggingFilter(HttpLogUtil httpLogUtil) {
        HttpLoggingFilter httpLoggingFilter = new HttpLoggingFilter(httpLogUtil);
        List<String> excludeUrlPatterns = Collections.singletonList("/testUrl");
        httpLoggingFilter.addExcludeUrlPatterns(excludeUrlPatterns);
        return httpLoggingFilter;
    }
}