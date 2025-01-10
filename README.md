# Livraria IMD

Aplicativo Android de um sistema  de cadastro e detalhamento de livros desenvolvido como avaliação da terceira unidade da disciplina de **Desenvolvimento para Dispositivos Móveis**  de 2024.2 da **Universidade Federal do Rio Grande do Norte**.

---

##  Funcionalidades

1. **Tela de Login**
   - Cadastro de novo usuário.
   - Redefinição de senha.
   - Armazenamento de informações de login utilizando `SharedPreferences`.

2. **Gerenciamento de Livros**
   - Cadastrar, listar, editar e excluir livros.
   - Manipulação dos dados via banco de dados SQLite.

3. **Tela de Cadastro de Livros**
   - Campos para:
     - Título
     - Autor
     - Editora
     - ISBN (identificador único)
     - Breve descrição
     - URL para a capa do livro (imagem carregada com Glide).
   - Salvamento no banco de dados.

4. **Listagem de Livros**
   - Exibição dos livros cadastrados em um `RecyclerView`.
   - Apresentação de:
     - Imagem da capa
     - Título
     - Editora
     - Autor
   - Acesso ao detalhamento do livro ao clicar no item da lista.

5. **Detalhamento de Livros**
   - Exibição de todos os atributos do livro:
     - Título
     - Autor
     - Editora
     - ISBN
     - Descrição
     - Capa

6. **Alteração de Livros**
   - Busca de um livro pelo ISBN.
   - Atualização das informações cadastradas.

7. **Exclusão de Livros**
   - Exclusão de livros pelo ISBN.

8. **Interação com o Usuário**
   - Feedbacks utilizando `Toast`.

---

##  Tecnologias Utilizadas

- **Linguagem**: Kotlin
- **IDE**: Android Studio
- **Banco de Dados**: SQLite
- **Carregamento de Imagens**: Glide
- **Interface Gráfica**: View Binding e XML
- **Componentes**: `RecyclerView`, `CardView`, `Toast`

---

##  Estrutura do Projeto

```plaintext
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/example/livrariaimd
│   │   │   │   ├── LoginActivity.kt           // Tela de Login
│   │   │   │   ├── MenuActivity.kt            // Tela de Menu Principal
│   │   │   │   ├── CadastroActivity.kt        // Tela de Cadastro de Livros
│   │   │   │   ├── ListagemActivity.kt        // Tela de Listagem de Livros
│   │   │   │   ├── DetalheLivroActivity.kt    // Tela de Detalhes do Livro
│   │   │   │   ├── AlterarLivroActivity.kt    // Tela de Alteração de Livros
│   │   │   │   ├── ExcluirLivroActivity.kt    // Tela de Exclusão de Livros
│   │   │   │   ├── DatabaseHelper.kt          // Classe para manipulação do banco de dados SQLite
│   │   │   │   ├── Livro.kt                   // Modelo de dados do Livro
│   │   │   │   ├── LivroAdaptador.kt          // Adapter para o RecyclerView
│   │   │   ├── res
│   │   │   │   ├── layout
│   │   │   │   │   ├── activity_login.xml         // Layout da tela de login
│   │   │   │   │   ├── activity_menu.xml          // Layout da tela de menu
│   │   │   │   │   ├── activity_cadastro.xml      // Layout da tela de cadastro
│   │   │   │   │   ├── activity_listagem.xml      // Layout da tela de listagem
│   │   │   │   │   ├── activity_detalhe_livro.xml // Layout da tela de detalhes
│   │   │   │   │   ├── activity_alterar_livro.xml // Layout da tela de alteração
│   │   │   │   │   ├── activity_excluir_livro.xml // Layout da tela de exclusão
│   │   │   │   │   ├── item_livro.xml             // Layout de item do RecyclerView
│   │   │   ├── AndroidManifest.xml               // Configurações do aplicativo
```
--- 
## Como Executar
1. Clone ou extraia o projeto em um ambiente de desenvolvimento Android (Android Studio).
2. Compile e execute o aplicativo em um dispositivo físico ou emulador.
3. Utilize as credenciais padrão para login:
   - **Usuário:** `admin`
   - **Senha:** `admin`
4. Navegue pelas funcionalidades disponíveis.

---

## Observações
- **Persistência de Dados**:
  - Todos os dados são armazenados no banco SQLite local.
- **Interface de Usuário**:
  - Design simples e funcional, com mensagens `Toast` para feedback.
- **Modularidade**:
  - Código organizado em classes separadas para cada funcionalidade.
