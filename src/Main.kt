fun main() {
    var digitalHouseManager = DigitalHouseManager()
    //Registro de professor adjunto
    digitalHouseManager.registrarProfessorAdjunto("Vitoria", "de Santoro Leone", 46, 60)
    digitalHouseManager.registrarProfessorAdjunto("Beatrice", "Dante di Mancini", 78, 32)
    //Registro de professor titular
    digitalHouseManager.registrarProfessorTitular("Carlos", "Lamborghini de Toscana", 25, "Inteigência Artificial")
    digitalHouseManager.registrarProfessorTitular("Cesari", "D'angelo Vitali Mugela", 56, "Orientação a Aspectos")
    //Registro de curso
    digitalHouseManager.registrarCurso("Full Stack", 20001, 3)
    digitalHouseManager.registrarCurso("Android", 20002, 2)
    //Alocação de professores
    digitalHouseManager.alocarProfessores(20001, 56, 46)
    digitalHouseManager.alocarProfessores(20002, 25, 78)
    //Matricula no curso de Full Stack

    digitalHouseManager.matricularAluno("Perla", "Coppola Ferri", 71)
    digitalHouseManager.matricularAluno("Giordana", "Parisi de Angelis", 28)
    digitalHouseManager.matricularAluno(71, 20001)
    digitalHouseManager.matricularAluno(28, 20001)
    //Matricula no curso android
    digitalHouseManager.matricularAluno("Alessia", "Bianco Amato", 53)
    digitalHouseManager.matricularAluno("Khyara", "Gatti Sala", 49)
    digitalHouseManager.matricularAluno("Elettra", "Grasso Pellegrini", 95)
    digitalHouseManager.matricularAluno(53, 20002)
    digitalHouseManager.matricularAluno(49, 20002)
    digitalHouseManager.matricularAluno(95, 20002)

}