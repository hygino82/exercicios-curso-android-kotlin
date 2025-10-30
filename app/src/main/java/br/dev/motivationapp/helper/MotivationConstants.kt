package br.dev.motivationapp.helper

class MotivationConstants private constructor() {
    object KEY {
        val PERSON_NAME = "personName"
    }

    object PHRASEFILTER {
        val ALL = 0
        val HAPPY = 1
        val SUNNY = 2
    }

    object LANGUAGE {
        const val ENGLISH = "en"
        const val FRENCH = "fr"
        const val PORTUGUESE = "pt"
    }
}