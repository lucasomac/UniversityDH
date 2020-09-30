class Curso(val nome: String, val codigo: Int, var qtdMaxAluno: Int) {
    lateinit var professorTitular: ProfessorTitular
    lateinit var professorAdjunto: ProfessorAdjunto
    var qtdAtualAluno = 0
    var alunosMtr = mutableListOf<Aluno>()
    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        when {
            this.qtdAtualAluno < this.qtdMaxAluno -> {
                alunosMtr.add(umAluno)
                qtdAtualAluno++
                return true
            }
            else -> {
                return false
            }
        }
    }

    fun excluirAluno(umAluno: Aluno) {
        try {
//            alunosMtr.filter { it == umAluno }
            alunosMtr.remove(umAluno)
            qtdAtualAluno--
        } catch (e: Exception) {
            println("Aluno não encontrado --> ${e.message}")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Curso
        if (codigo != other.codigo) return false
        return true
    }

    override fun hashCode(): Int {
        return codigo
    }

    override fun toString(): String {
        return "Curso(nome='$nome', codigo=$codigo, qtdMaxAluno=$qtdMaxAluno)"
    }
}