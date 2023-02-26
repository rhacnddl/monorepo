package com.gorany.config

import org.springframework.data.domain.AuditorAware
import java.util.*

class SecurityAuditAware : AuditorAware<String> {

    companion object {
        private const val SYSTEM = "SYSTEM"
    }

    override fun getCurrentAuditor(): Optional<String> {

        return Optional.of(SYSTEM)
    }

}
