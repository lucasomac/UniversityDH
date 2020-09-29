class Curso(val nome: String, val codigo: Int, var professorTitular: ProfessorTitular, var professorAdjunto: ProfessorAdjunto, qtdMaxAluno: Int) {
    var alunosMtr = listOf<Aluno>()
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