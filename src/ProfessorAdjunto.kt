class ProfessorAdjunto(override val nome: String, override var sobrenome: String, override val codigo: Int, var qtdHrMonitoria: Int) : Professor {
    override var tempoCasa = 0
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ProfessorAdjunto
        if (codigo != other.codigo) return false
        return true
    }

    override fun hashCode(): Int {
        return codigo
    }
}