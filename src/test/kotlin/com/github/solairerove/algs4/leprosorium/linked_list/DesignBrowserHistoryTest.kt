package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DesignBrowserHistoryTest : FunSpec({

    test("design browser history basic test") {
        val browserHistory = BrowserHistory("leetcode.com")
        browserHistory.visit("google.com") // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com") // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com") // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1) shouldBe "facebook.com" // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1) shouldBe "google.com"  // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1) shouldBe "facebook.com" // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com") // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2) shouldBe "linkedin.com" // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2) shouldBe "google.com" // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7) shouldBe "leetcode.com" // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
})
