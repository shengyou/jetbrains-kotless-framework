package io.kraftsman.dtos

import kotlinx.serialization.Serializable

@Serializable
data class ContactApiResponse (val data: List<Contact>)
