package view

import NGP.view.AppController
import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.text.Font
import tornadofx.*


class historyInterface : View("Historial") {
    val appController: AppController by  inject()
    override val root = borderpane {
        setPrefSize(800.0, 600.0)

        top {
            label(title) {
                font = Font.font(22.0)
            }
        }

        center {
            vbox(spacing = 15) {
                alignment = Pos.CENTER


                hbox {
                    alignment = Pos.CENTER

                    button("Regresar") {
                        setOnAction {
                            appController.showMainView()
                        }
                    }


                }
            }
        }
    }
}