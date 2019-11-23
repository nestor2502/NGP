package NGP.view

import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.event.EventHandler
import javafx.util.Duration
import no.tornado.fxsample.login.Styles.Companion.loginScreen
import tornadofx.*
import code.Torneo

class TournamentView : View("Tournament") {
    val AppController: AppController by inject()

    private val model = object : ViewModel() {
        val username = bind { SimpleStringProperty() }
        val password = bind { SimpleStringProperty() }
        val remember = bind { SimpleBooleanProperty() }
    }

    override val root = form {
        addClass(TournamentView)

        button("Login") {
            isDefaultButton = true

            action {
                model.commit {
                    AppController.tryLogin(
                            model.username.value,
                            model.password.value,
                            model.remember.value
                    )
                }
            }
        }
    }

    fun playTournament () {
        var torneo = Torneo(6000)
        torneo.organizaCombates()


    }

    override fun onDock() {
        model.validate(decorateErrors = false)
    }

    fun shakeStage() {
        var x = 0
        var y = 0
        val cycleCount = 10
        val move = 10
        val keyframeDuration = Duration.seconds(0.04)

        val stage = FX.primaryStage

        val timelineX = Timeline(KeyFrame(keyframeDuration, EventHandler {
            if (x == 0) {
                stage.x = stage.x + move
                x = 1
            } else {
                stage.x = stage.x - move
                x = 0
            }
        }))

        timelineX.cycleCount = cycleCount
        timelineX.isAutoReverse = false

        val timelineY = Timeline(KeyFrame(keyframeDuration, EventHandler {
            if (y == 0) {
                stage.y = stage.y + move
                y = 1
            } else {
                stage.y = stage.y - move
                y = 0
            }
        }))

        timelineY.cycleCount = cycleCount
        timelineY.isAutoReverse = false

        timelineX.play()
        timelineY.play()
    }

    fun clear() {
        model.username.value = ""
        model.password.value = ""
        model.remember.value = false
    }
}