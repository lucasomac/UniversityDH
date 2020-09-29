class DigitalHouseManager() {
    var listAlunos: MutableList<Aluno> = mutableListOf()
    var listProfessores: MutableList<Professor> = mutableListOf()
    var listCursos: MutableList<Curso> = mutableListOf()
    var listMatriculas: MutableList<Matricula> = mutableListOf()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        this.listCursos.add(Curso(nome, codigoCurso, quantidadeMaximaDeAlunos))
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
    }

    fun excluirProfessor(codigoProfessor: Int) {
        this.listProfessores.removeIf { it.codigo == codigoProfessor }
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        this.listAlunos.add(Aluno(nome, sobrenome, codigoAluno))
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        val aluno = this.listAlunos.find { it.codigo == codigoAluno }
        val curso = this.listCursos.find { it.codigo == codigoCurso }
        when {
            aluno == null || curso == null -> println("Curso ou Matricula não encontrado")
            else -> when {
                curso.qtdAtualAluno < curso.qtdMaxAluno -> println("Não foi possível realizar a matrícula porque não há vagas.")
                else -> {
                    this.listMatriculas.add(Matricula(aluno, curso))
                    println("Matrícula realizada com sucesso!")
                }
            }
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        val profAdjunto = this.listProfessores.binarySearch { codigoProfessorAdjunto }
        val profTitular = this.listProfessores.binarySearch { codigoProfessorTitular }
        val curso = this.listCursos.binarySearch { codigoCurso }
        when {
            profAdjunto == -1 || profTitular == -1 || curso == -1 -> println("Curso ou Matricula não encontrado")
            else -> {
                this.listCursos.get(curso).professorAdjunto = this.listProfessores.get(profAdjunto) as ProfessorAdjunto
                this.listCursos.get(curso).professorTitular = this.listProfessores.get(profTitular) as ProfessorTitular
            }
        }
    }
}
