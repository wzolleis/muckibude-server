package de.wz.muckibude.status

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @RequestMapping("/greeting")
    fun greeting() : Greeting {
        return Greeting("world");
    }
}