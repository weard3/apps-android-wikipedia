package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase

class KaspressoConfigurationTest: TestCase(
    kaspressoBuilder = Kaspresso.Builder.advanced {
        flakySafetyParams = FlakySafetyParams.custom(
            // задаем таймаут
            timeoutMs = 30_000,
            allowedExceptions = FlakySafetyParams.defaultAllowedExceptions + NullPointerException::class.java
        )
    }
)