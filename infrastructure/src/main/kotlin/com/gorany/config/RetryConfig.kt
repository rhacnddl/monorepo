package com.gorany.config

import org.springframework.context.annotation.Configuration
import org.springframework.retry.annotation.EnableRetry

@Configuration
@EnableRetry
class RetryConfig {
    companion object {
        const val RETRY_MAX_ATTEMPT = 3
        const val RETRY_DEFAULT_BACKOFF_TIME = 1000L
    }
}
