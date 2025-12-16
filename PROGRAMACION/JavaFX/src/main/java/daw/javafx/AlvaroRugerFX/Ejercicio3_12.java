package daw.javafx.AlvaroRugerFX;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_12 extends Ejercicio {

    public Ejercicio3_12(String name, boolean finished) {
		super(name, finished);
    }

    public <T> T[] concatenate(T[] a, T[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }

    public class Quest {
        public String name = "";
        public Answer[] corrects, incorrects;
        public List<Answer> alls;
        public boolean multiple = false;

        public Quest(String name, Answer[] corrects, Answer[] incorrects, boolean multiple) {
            this.name = name;
            this.corrects = corrects;
            this.incorrects = incorrects;
            this.multiple = multiple;
            this.alls = Arrays.asList(concatenate(corrects, incorrects));
            Collections.shuffle(this.alls);
        }
    }

    public enum ANS_TYPE {RADIO, CHECK}

    public class Answer {
        public String name = "";
        public ANS_TYPE type = ANS_TYPE.RADIO;

        public Answer(String name, ANS_TYPE type) {
            this.name = name;
            this.type = type;
        }
    }

    public void start(Stage stage) {

        final Quest[] quests = {
                new Quest("En Java, toda sentencia debe acabar con ; como norma general:",
                        new Answer[]{new Answer("Verdadero", ANS_TYPE.RADIO)},
                        new Answer[]{new Answer("Falso", ANS_TYPE.RADIO)},
                        false),

                new Quest("¿Qué lenguajes se utilizan principalmente para desarrollar páginas web? (Marca todas las que correspondan)",
                        new Answer[]{
                                new Answer("HTML", ANS_TYPE.CHECK),
                                new Answer("CSS", ANS_TYPE.CHECK),
                                new Answer("JavaScript", ANS_TYPE.CHECK)
                        },
                        new Answer[]{new Answer("Python", ANS_TYPE.CHECK)},
                        true),

                new Quest("¿Cuál es el lenguaje de estilo usado para diseñar páginas web?",
                        new Answer[]{new Answer("CSS", ANS_TYPE.RADIO)},
                        new Answer[]{new Answer("HTML", ANS_TYPE.RADIO),
                                new Answer("Python", ANS_TYPE.RADIO),
                                new Answer("Java", ANS_TYPE.RADIO)},
                        false),

                new Quest("¿Qué tecnologías frontend son frameworks populares? (Marca todas las que correspondan)",
                        new Answer[]{
                                new Answer("Angular", ANS_TYPE.CHECK),
                                new Answer("React", ANS_TYPE.CHECK)
                        },
                        new Answer[]{
                                new Answer("Servlets", ANS_TYPE.CHECK),
                                new Answer("Spring", ANS_TYPE.CHECK),
                                new Answer("Hibernate", ANS_TYPE.CHECK)},
                        true),

                new Quest("¿Qué gestor de bases de datos relacional es común en aplicaciones DAW?",
                        new Answer[]{new Answer("MySQL", ANS_TYPE.RADIO)},
                        new Answer[]{new Answer("MongoDB", ANS_TYPE.RADIO),
                                new Answer("Redis", ANS_TYPE.RADIO),
                                new Answer("Firebase", ANS_TYPE.RADIO)},
                        false),

                new Quest("¿Qué protocolo se utiliza para enviar datos de formulario en una aplicación web?",
                        new Answer[]{new Answer("HTTP POST", ANS_TYPE.RADIO)},
                        new Answer[]{new Answer("FTP", ANS_TYPE.RADIO),
                                new Answer("SMTP", ANS_TYPE.RADIO),
                                new Answer("TCP", ANS_TYPE.RADIO)},
                        false),

                new Quest("¿Cuál de los siguientes es un framework backend popular?",
                        new Answer[]{new Answer("Spring", ANS_TYPE.RADIO)},
                        new Answer[]{new Answer("Angular", ANS_TYPE.RADIO),
                                new Answer("React", ANS_TYPE.RADIO),
                                new Answer("Django", ANS_TYPE.RADIO)},
                        false),

                new Quest("¿Qué patrón de diseño se usa para separar la lógica de negocio y la interfaz en aplicaciones web?",
                        new Answer[]{new Answer("MVC (Modelo-Vista-Controlador)", ANS_TYPE.RADIO)},
                        new Answer[]{new Answer("Singleton", ANS_TYPE.RADIO),
                                new Answer("Factory", ANS_TYPE.RADIO),
                                new Answer("Observer", ANS_TYPE.RADIO)},
                        false),

                new Quest("¿Cuál de estas bases de datos es NoSQL?",
                        new Answer[]{new Answer("MongoDB", ANS_TYPE.RADIO)},
                        new Answer[]{new Answer("Oracle", ANS_TYPE.RADIO),
                                new Answer("PostgreSQL", ANS_TYPE.RADIO),
                                new Answer("MySQL", ANS_TYPE.RADIO)},
                        false),

                new Quest("¿Qué lenguaje se usa para programar la lógica del lado cliente en aplicaciones web?",
                        new Answer[]{new Answer("JavaScript", ANS_TYPE.RADIO)},
                        new Answer[]{new Answer("Java", ANS_TYPE.RADIO),
                                new Answer("PHP", ANS_TYPE.RADIO),
                                new Answer("Python", ANS_TYPE.RADIO)},
                        false)
        };

        VBox content = new VBox(10);
        content.setPadding(new Insets(20));
        content.setPrefWidth(800);

        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Text description = new Text(
                "12. Realiza un minicuestionario con 10 preguntas tipo test sobre los módulos (asignaturas) que se imparten en el curso.\n"
                        + "Cada pregunta acertada sumará un punto. El programa mostrará al final la calificación obtenida.\n"
                        + "Pásale el minicuestionario a tus compañeros y pídeles que lo hagan para ver qué tal andan de conocimientos.");
        description.setWrappingWidth(780);
        description.setFont(Font.font(14));

        content.getChildren().add(description);

        Text instruction = new Text("Contesta las preguntas correctamente:");
        instruction.setFont(Font.font(16));
        content.getChildren().add(instruction);

        List<ToggleGroup> toggleGroups = new ArrayList<>();
        List<List<CheckBox>> checkBoxLists = new ArrayList<>();

        int questionNumber = 1;
        for (Quest quest : quests) {
            VBox questionBox = new VBox(5);

            Text questionText = new Text(questionNumber + ". " + quest.name);
            questionText.setFont(Font.font(14));
            questionText.setWrappingWidth(780);
            questionBox.getChildren().add(questionText);

            if (!quest.multiple) {
                ToggleGroup tg = new ToggleGroup();
                toggleGroups.add(tg);
                checkBoxLists.add(null); 

                for (Answer ans : quest.alls) {
                    RadioButton rb = new RadioButton(ans.name);
                    rb.setToggleGroup(tg);
                    questionBox.getChildren().add(rb);
                }
            } else {
                toggleGroups.add(null);
                List<CheckBox> cbs = new ArrayList<>();
                checkBoxLists.add(cbs);

                for (Answer ans : quest.alls) {
                    CheckBox cb = new CheckBox(ans.name);
                    cbs.add(cb);
                    questionBox.getChildren().add(cb);
                }
            }

            content.getChildren().add(questionBox);
            questionNumber++;
        }

        Button submit = new Button("Enviar");
        Label resultLabel = new Label();
        resultLabel.setFont(Font.font(16));

        submit.setOnAction(e -> {
            int score = 0;

            for (int idx = 0; idx < quests.length; idx++) {
                Quest quest = quests[idx];

                if (!quest.multiple) {
                    ToggleGroup tg = toggleGroups.get(idx);
                    Toggle selected = tg.getSelectedToggle();

                    if (selected != null) {
                        RadioButton selectedButton = (RadioButton) selected;
                        String selectedText = selectedButton.getText();

                        for (Answer correctAns : quest.corrects) {
                            if (correctAns.name.equals(selectedText)) {
                                score++;
                                break;
                            }
                        }
                    }
                } else {
                    List<CheckBox> cbs = checkBoxLists.get(idx);

                    boolean allCorrectSelected = true;
                    for (Answer correctAns : quest.corrects) {
                        boolean foundSelected = false;
                        for (CheckBox cb : cbs) {
                            if (cb.getText().equals(correctAns.name) && cb.isSelected()) {
                                foundSelected = true;
                                break;
                            }
                        }
                        if (!foundSelected) {
                            allCorrectSelected = false;
                            break;
                        }
                    }

                    boolean anyIncorrectSelected = false;
                    for (Answer incorrectAns : quest.incorrects) {
                        for (CheckBox cb : cbs) {
                            if (cb.getText().equals(incorrectAns.name) && cb.isSelected()) {
                                anyIncorrectSelected = true;
                                break;
                            }
                        }
                        if (anyIncorrectSelected) break;
                    }

                    if (allCorrectSelected && !anyIncorrectSelected) {
                        score++;
                    }
                }
            }

            resultLabel.setText("Nota: " + score + " / " + quests.length);
        });

        VBox buttonBox = new VBox(10);
        buttonBox.setPadding(new Insets(20, 0, 0, 0));
        buttonBox.getChildren().addAll(submit, resultLabel);

        content.getChildren().add(buttonBox);

        Scene scene = new Scene(scrollPane, 900, 700);
        stage.setTitle("Cuestionario DAW");
        stage.setScene(scene);
        stage.show();
    }
}
