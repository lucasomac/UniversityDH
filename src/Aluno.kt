class Aluno(val nome: String, var sobrenome: String, val codigo: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Aluno
        if (codigo != other.codigo) return false
        return true
    }

    override fun hashCode(): Int {
        return codigo
    }

    override fun toString(): String {
        return "Aluno(nome='$nome', sobrenome='$sobrenome', codigo=$codigo)"
    }
}