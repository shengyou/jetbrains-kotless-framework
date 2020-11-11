package io.kraftsman.functions

import io.kotless.dsl.lang.http.Get
import io.kotless.dsl.lang.http.html
import io.kotless.dsl.model.HttpResponse

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
