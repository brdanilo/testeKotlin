import java.util.Random

fun main() {
    println("Bem-vindo ao Jogo da Forca!")
    println("Tente adivinhar a palavra secreta.\n")

    // Lista de palavras para o jogo
    val palavras = listOf(
        "kotlin", "programacao", "computador", "algoritmo", 
        "desenvolvedor", "terminal", "jogo", "forca"
    )
    
    val random = Random()
    val palavraSecreta = palavras[random.nextInt(palavras.size)].uppercase()
    val letrasCorretas = mutableSetOf<Char>()
    val letrasErradas = mutableSetOf<Char>()
    var tentativasRestantes = 6
    
    while (true) {
        // Mostra o estado atual do jogo
        desenharForca(tentativasRestantes)
        mostrarPalavra(palavraSecreta, letrasCorretas)
        
        if (letrasCorretas.size == palavraSecreta.toSet().size) {
            println("\nParabéns! Você acertou a palavra: $palavraSecreta")
            break
        }
        
        if (tentativasRestantes <= 0) {
            println("\nGame Over! A palavra era: $palavraSecreta")
            break
        }
        
        println("\nLetras erradas: ${letrasErradas.joinToString(" ")}")
        println("Tentativas restantes: $tentativasRestantes")
        
        // Pede ao jogador para fazer um palpite
        print("Digite uma letra: ")
        val input = readLine()?.trim()?.uppercase() ?: ""
        
        if (input.length != 1 || !input[0].isLetter()) {
            println("Por favor, digite apenas uma letra válida.")
            continue
        }
        
        val letra = input[0]
        
        if (letra in letrasCorretas || letra in letrasErradas) {
            println("Você já tentou esta letra. Tente outra.")
            continue
        }
        
        if (letra in palavraSecreta) {
            letrasCorretas.add(letra)
            println("Boa! A letra '$letra' está na palavra.")
        } else {
            letrasErradas.add(letra)
            tentativasRestantes--
            println("Ops! A letra '$letra' não está na palavra.")
        }
    }
}

fun mostrarPalavra(palavra: String, letrasCorretas: Set<Char>) {
    val palavraOculta = palavra.map { 
        if (it in letrasCorretas) it else '_' 
    }.joinToString(" ")
    
    println("\nPalavra: $palavraOculta")
}

fun desenharForca(tentativasRestantes: Int) {
    when (tentativasRestantes) {
        6 -> {
            println("  _______")
            println(" |/      |")
            println(" |")
            println(" |")
            println(" |")
            println(" |")
            println("_|___")
        }
        5 -> {
            println("  _______")
            println(" |/      |")
            println(" |      (_)")
            println(" |")
            println(" |")
            println(" |")
            println("_|___")
        }
        4 -> {
            println("  _______")
            println(" |/      |")
            println(" |      (_)")
            println(" |       |")
            println(" |       |")
            println(" |")
            println("_|___")
        }
        3 -> {
            println("  _______")
            println(" |/      |")
            println(" |      (_)")
            println(" |      \\|")
            println(" |       |")
            println(" |")
            println("_|___")
        }
        2 -> {
            println("  _______")
            println(" |/      |")
            println(" |      (_)")
            println(" |      \\|/")
            println(" |       |")
            println(" |")
            println("_|___")
        }
        1 -> {
            println("  _______")
            println(" |/      |")
            println(" |      (_)")
            println(" |      \\|/")
            println(" |       |")
            println(" |      /")
            println("_|___")
        }
        0 -> {
            println("  _______")
            println(" |/      |")
            println(" |      (_)")
            println(" |      \\|/")
            println(" |       |")
            println(" |      / \\")
            println("_|___")
        }
    }
}
