package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.homeworks.homework20.NamedSteps

private val stepContextCache = mutableMapOf<TestContext<*>, Steps>()
private val namedStepsCache = mutableMapOf<TestContext<*>, NamedSteps>()
val TestContext<*>.steps: Steps
    get() = stepContextCache.getOrPut(this) { Steps(this) }
val TestContext<*>.namedSteps: NamedSteps
    get() = namedStepsCache.getOrPut(this) { NamedSteps(this) }