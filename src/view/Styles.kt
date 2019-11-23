package view

import javafx.scene.paint.Color
import tornadofx.*
import java.net.URI

class Styles : Stylesheet() {
    companion object {
        val loginStyle by cssclass()
        val registerStyle by cssclass()
    }

    init {
        loginStyle {
            padding = box(15.px)
            vgap = 7.px
            hgap = 10.px
            backgroundColor += Color.AQUA
        }
        registerStyle{
            padding = box(15.px)
            vgap = 7.px
            hgap = 10.px
            backgroundColor += Color.ALICEBLUE
        }
    }
}