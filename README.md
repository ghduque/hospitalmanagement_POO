# Sistema de Gerenciamento Hospitalar | Hospital Management System

## Português

### Descrição do Projeto

Este projeto consiste no desenvolvimento de um Sistema de Gerenciamento Hospitalar, com foco na organização e controle dos dados de pacientes e profissionais de saúde. A aplicação foi desenvolvida em Java 21 com interface gráfica em JavaFX, seguindo os princípios da Programação Orientada a Objetos (POO) e a arquitetura MVC.

O sistema foi projetado para atender as necessidades do Hospital Vida Plena, oferecendo funcionalidades como cadastro, edição, remoção e visualização de registros, com foco em modularidade, segurança da informação e facilidade de manutenção.

### Funcionalidades

- Cadastro de pacientes e funcionários (médicos, enfermeiros, recepcionistas e equipe de limpeza)
- Edição de dados cadastrados
- Remoção de registros
- Listagem e visualização por categoria
- Relacionamento entre profissionais e pacientes (associação do tipo agregação)
- Interface gráfica desenvolvida com JavaFX (FXML e CSS)
- Separação em camadas (Model-View-Controller)
- Persistência de dados com padrão DAO

### Tecnologias e Ferramentas

- Java 21
- JavaFX (FXML, CSS)
- Eclipse IDE
- Padrões de Projeto: MVC e DAO
- Estruturas de Dados Java (ArrayList)

### Estrutura de Classes

- Superclasse: `Pessoa`
- Subclasses:
  - `Paciente`
  - `Funcionario`
    - `Medico`
    - `Enfermeira`
    - `Recepcionista`
    - `FuncionarioLimpeza`

### Como Executar

1. Clone o repositório:
   ```
   git clone https://github.com/ghduque/hospitalmanagement_POO.git
   ```

2. Abra o projeto no Eclipse (com suporte ao JavaFX configurado).

3. Compile e execute a partir da classe `Main`.

### Autores

- Gabriel Henrique Silva Duque  
- Rafael Gonçalves Oliveira  
Professor Orientador: Felipe Lopes de Melo Faria

---

## English

### Project Description

This project involves the development of a Hospital Management System, focused on organizing and controlling data related to patients and healthcare professionals. The application was developed in Java 21 with a graphical user interface built using JavaFX, following Object-Oriented Programming (OOP) principles and the MVC architecture.

The system was designed to meet the needs of Hospital Vida Plena, offering features such as registration, editing, removal, and viewing of records, with an emphasis on modularity, data security, and maintainability.

### Features

- Registration of patients and employees (doctors, nurses, receptionists, and cleaning staff)
- Editing existing records
- Record removal
- Listing and viewing by category
- Professional–patient relationship modeled as aggregation
- Graphical interface using JavaFX (FXML and CSS)
- Layered architecture (Model-View-Controller)
- Data persistence using DAO pattern

### Technologies and Tools

- Java 21
- JavaFX (FXML, CSS)
- Eclipse IDE
- Design Patterns: MVC and DAO
- Java Data Structures (ArrayList)

### Class Structure

- Superclass: `Pessoa` (Person)
- Subclasses:
  - `Paciente` (Patient)
  - `Funcionario` (Employee)
    - `Medico` (Doctor)
    - `Enfermeira` (Nurse)
    - `Recepcionista` (Receptionist)
    - `FuncionarioLimpeza` (CleaningStaff)

### How to Run

1. Clone the repository:
   ```
   git clone https://github.com/ghduque/hospitalmanagement_POO.git
   ```

2. Open the project in Eclipse (ensure JavaFX is properly configured).

3. Compile and run the `Main` class.

### Authors

- Gabriel Henrique Silva Duque  
- Rafael Gonçalves Oliveira  
Advisor: Felipe Lopes de Melo Faria