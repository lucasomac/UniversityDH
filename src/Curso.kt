class Curso(val nome: String, val codigo: Int, var professorTitular: ProfessorTitular, var professorAdjunto: ProfessorAdjunto, var qtdMaxAluno: Int) {
    private var qtdAtualAluno = 0
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
}