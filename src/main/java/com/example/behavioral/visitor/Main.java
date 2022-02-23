package com.example.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
Representar una operación a realizar sobre los elementos de una
estructura de objetos. El visitante permite definir una nueva operación
sin cambiar las clases de los elementos sobre los que opera.
 */
public class Main {

    public static void main(String[] args) {

        Visitor v = new ElementVisitor();

        Document d = new Document(UUID.randomUUID().toString());
        d.addElement(new JsonElement(UUID.randomUUID().toString()));
        d.addElement(new JsonElement(UUID.randomUUID().toString()));
        d.addElement(new XmlElement(UUID.randomUUID().toString()));

        d.accept(v);
    }
}


class JsonElement extends Element {

    public JsonElement(String uuid) {
        super(uuid);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
class XmlElement extends Element {

    public XmlElement(String uuid) {
        super(uuid);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
class Footer extends Element{
    String content;

    public Footer(String uuid) {
        super(uuid);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Footer(String uuid, String content) {
        super(uuid);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
interface Visitor {

    void visit(XmlElement xe);

    void visit(JsonElement je);

    String visit(Footer footer);
}
abstract class Element {

    public String uuid;

    public Element(String uuid) {
        this.uuid = uuid;
    }

    public abstract void accept(Visitor v);
}
class Document extends Element {

    List<Element> elements = new ArrayList<>();

    public Document(String uuid) {
        super(uuid);
    }

    public void addElement(Element element){
        this.elements.add(element);
    }
    @Override
    public void accept(Visitor v) {
        for (Element e : this.elements) {
            e.accept(v);
        }
    }
}
class ElementVisitor implements Visitor {

    @Override
    public void visit(XmlElement xe) {
        System.out.println("processing xml element with uuid: " + xe.uuid);
    }

    @Override
    public void visit(JsonElement je) {
        System.out.println("processing json element with uuid: " + je.uuid);
    }

    @Override
    public String visit(Footer footer) {
        return String.format("<footer>%s</footer>", footer.getContent());
    }
}