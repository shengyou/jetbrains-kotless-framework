package io.kraftsman.functions

import com.github.javafaker.Faker
import io.kotless.dsl.lang.KotlessContext
import io.kotless.dsl.lang.http.Get
import io.kotless.dsl.lang.http.html
import io.kotless.dsl.lang.http.json
import io.kotless.dsl.model.HttpResponse
import io.kraftsman.dtos.Contact
import io.kraftsman.dtos.ContactApiResponse
import io.kraftsman.services.ContactService
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.util.*
import kotlin.random.Random
import kotlin.time.ExperimentalTime
import kotlin.time.hours
import kotlin.time.minutes

@Get("/")
fun home(): HttpResponse {
    val dom = """<!doctype html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0'>
    <meta http-equiv='X-UA-Compatible' content='ie=edge'>
    <title>Hello, Kotless</title>
</head>
<body>
    <h1>Hello, Kotless</h1>
</body>
</html>""".trimIndent()

    return html(dom)
}

@ExperimentalTime
@Get("/contacts")
fun contactAPI(): HttpResponse {

    val param = KotlessContext.HTTP.request.params?.get("amount")
    val amount = param?.toIntOrNull() ?: 10

    val contacts = ContactService().generate(amount)
    val contactResponse = ContactApiResponse(contacts)
    val json = Json(JsonConfiguration.Stable)
    val jsonString = json.stringify(ContactApiResponse.serializer(), contactResponse)

    return json(jsonString)
}