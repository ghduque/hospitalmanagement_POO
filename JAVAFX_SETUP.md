## Configuração do JavaFX | JavaFX Setup

### Português

Para executar este projeto com JavaFX, é necessário configurar corretamente a biblioteca no ambiente de desenvolvimento. Siga os passos abaixo no Eclipse:

1. Baixe o SDK do JavaFX em: https://gluonhq.com/products/javafx/
2. Extraia o conteúdo e salve em um diretório acessível.
3. No Eclipse, vá em:
   - `Project` > `Properties` > `Java Build Path` > `Libraries`
   - Adicione os arquivos JAR da pasta `lib` do JavaFX.
4. Ainda em `Properties`, vá em:
   - `Run/Debug Settings` > `Edit Configuration`
   - Em `VM arguments`, adicione:
     ```
     --module-path "CAMINHO_PARA_JAVAFX/lib" --add-modules javafx.controls,javafx.fxml
     ```

Substitua `CAMINHO_PARA_JAVAFX` pelo caminho real onde está o SDK do JavaFX.

### English

To run this project with JavaFX, the library must be properly configured in your development environment. Follow the steps below using Eclipse:

1. Download the JavaFX SDK from: https://gluonhq.com/products/javafx/
2. Extract it and save it in an accessible directory.
3. In Eclipse, go to:
   - `Project` > `Properties` > `Java Build Path` > `Libraries`
   - Add the JAR files located in the `lib` folder of JavaFX.
4. Then go to:
   - `Run/Debug Settings` > `Edit Configuration`
   - In `VM arguments`, add:
     ```
     --module-path "PATH_TO_JAVAFX/lib" --add-modules javafx.controls,javafx.fxml
     ```

Replace `PATH_TO_JAVAFX` with the actual path to your JavaFX SDK.