package com.kotlin.news_api.data.api

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.common.truth.Truth.assertThat


class NewsApiServiceTest {

    private lateinit var service: NewsApiService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer();
        service = Retrofit.Builder().baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create()).build().create(NewsApiService::class.java);
    }

    @After
    fun tearDown() {
        server.shutdown();
    }

    private fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName);
        val source = inputStream.source().buffer();
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8));
        server.enqueue(mockResponse);
    }

    @Test
    fun getTopHeadLines_sentRequest_receiveExpected() {
        runBlocking {
            enqueueMockResponse("newsresources.json")
            val responseBody=service.getTopHeadLines("us", 3)
            val request=server.takeRequest()
            assertThat(responseBody).isNotNull();
        }
    }

}