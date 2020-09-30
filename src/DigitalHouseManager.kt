class DigitalHouseManager() {
    var listAlunos: MutableList<Aluno> = mutableListOf()
    var listProfessores: MutableList<Professor> = mutableListOf()
    var listCursos: MutableList<Curso> = mutableListOf()
    var listMatriculas: MutableList<Matricula> = mutableListOf()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        this.listCursos.add(Curso(nome, codigoCurso, quantidadeMaximaDeAlunos))
        this.listCursos.sortBy { it.codigo }
    }

    fun excluirCurso(codigoCurso: Int) {
        this.listCursos.removeIf { it.codigo == codigoCurso }
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        this.listProfessores.add(ProfessorAdjunto(nome, sobrenome, codigoProfessor, quantidadeDeHoras))
        this.listProfessores.sortBy { it.codigo }
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        this.listProfessores.add(ProfessorTitular(nome, sobrenome, codigoProfessor, especialidade))
        this.listProfessores.sortBy { it.codigo }
    }

    fun excluirProfessor(codigoProfessor: Int) {
        this.listProfessores.removeIf { it.codigo == codigoProfessor }
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        this.listAlunos.add(Aluno(nome, sobrenome, codigoAluno))
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        val aluno = this.listAlunos.find { it.codigo == codigoAluno }
        val curso = this.listCursos.binarySearchBy(codigoCurso) { it.codigo }
        when {
            aluno == null || curso == -1 -> println("Curso ou Matricula não encontrado")
            else -> when {
                this.listCursos[curso].qtdAtualAluno >= this.listCursos[curso].qtdMaxAluno -> println("Não foi possível realizar a matrícula porque não há vagas.")
                else -> {
                    this.listMatriculas.add(Matricula(aluno, this.listCursos[curso]))
                    this.listCursos[curso].adicionarUmAluno(aluno)
                    println("Matrícula realizada com sucesso!")
                }
            }
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        val profAdjunto = this.listProfessores.binarySearchBy(codigoProfessorAdjunto) { it.codigo }
        val profTitular = this.listProfessores.binarySearchBy(codigoProfessorTitular) { it.codigo }
        val curso = this.listCursos.binarySearchBy(codigoCurso) { it.codigo }
        when {
            profAdjunto == -1 || profTitular == -1 || curso == -1 -> println("Curso ou professor não encontrado ")
            else -> {
                this.listCursos[curso].professorAdjunto = this.listProfessores.get(profAdjunto) as ProfessorAdjunto
                this.listCursos[curso].professorTitular = this.listProfessores.get(profTitular) as ProfessorTitular
            }
        }
    }
}
