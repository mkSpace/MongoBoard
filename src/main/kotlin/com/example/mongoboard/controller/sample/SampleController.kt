package com.example.mongoboard.controller.sample

import com.example.mongoboard.Constants.API_ENDPOINT
import com.example.mongoboard.model.sample.Sample
import com.example.mongoboard.model.sample.SampleService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("$API_ENDPOINT/sample")
class SampleController(private val sampleService: SampleService) {

    @PostMapping
    fun createSample(@RequestBody request: SampleCreateRequest): Sample {
        return sampleService.createSample(request.firstName, request.lastName)
    }

}