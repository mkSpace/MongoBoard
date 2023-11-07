package com.example.mongoboard.service.sample

import com.example.mongoboard.model.sample.Sample
import com.example.mongoboard.model.sample.SampleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class SampleService(private val sampleRepository: SampleRepository) {

    @Transactional
    fun createSample(firstName: String, lastName: String): Sample {
        val sample = Sample(firstName = firstName, lastName = lastName)
        sampleRepository.save(sample)
        return sample
    }

}