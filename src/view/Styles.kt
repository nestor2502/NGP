package view

import tornadofx.*

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
        }
        registerStyle{
            padding = box(15.px)
            vgap = 7.px
            hgap = 10.px
        }
    }
}