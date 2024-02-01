package furhatos.app.medicalscreener.flow

import furhatos.event.Event

data class ShowScreenEvent(val title: String, val text: String) : Event("ShowScreenEvent")

data class AppendTextEvent(val text: String) : Event("AppendTextEvent")

data class SetLanguageEvent(val language: String) : Event("SetLanguageEvent")

data class ShowOptionsEvent(
        val options: List<String>,
        val prompt: String? = null,
        val append: Boolean = false,
        val delaySeconds: Double = 0.5,
        val title: String? = null
) : Event("ShowOptionsEvent")

data class ShowFacesEvent(
        val showFaces: String? = "show",
        val delaySeconds: Double = 0.5,
) : Event("ShowFacesEvent")

data class ShowResultsEvent(
        val results: String,
        val positive: Boolean,
        val score: Int
) : Event("ShowResultsEvent")

class ClearScreen() : Event("ClearScreen")

data class OptionSelectedEvent(
        val option: String?
) : Event("OptionSelectedEvent")

class ShowAboutFurhat : Event("ShowAboutFurhatEvent")

class CloseModal : Event("CloseModalEvent")


