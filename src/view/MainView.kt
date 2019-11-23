package NGP.view

import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.text.Font
import tornadofx.*

class MainView : View("Main Page") {
    val AppController: AppController by inject()
    val TournamentView: TournamentView by inject()

    override val root = borderpane {
        setPrefSize(900.0, 900.0)

        top {
            label(title) {
                font = Font.font(22.0)
            }
        }

        center {
            vbox(spacing = 15) {
                alignment = Pos.CENTER

                label("If you can see this, you are successfully logged in!")

                hbox {
                    alignment = Pos.CENTER

                    button("Logout") {
                        setOnAction {
                            AppController.logout()
                        }
                    }

                    button("Exit") {
                        setOnAction {
                            Platform.exit()
                        }
                    }

                    button("Jugar") {
                        isDefaultButton = true

                        action {
                                AppController.showTournamentView()
                                TournamentView.playTournament()
                            }
                        }
                    }

                    button("Ver historial") {
                        isDefaultButton = true

                        action {
                                AppController.showHistoryInterface()
                            }
                        }
                    }
                }
            }
        }
