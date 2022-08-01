// Imports
import { BoardController } from "./Controller/Board_Controller.mjs"

// Contenedores html
const root = document.getElementById("root")

/**
 * instancia del controlador del tablero y lanzamiento de la vista
 */
let launch = new BoardController()
launch.generateViews()


