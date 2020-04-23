package pl.michalkarwowski.processmodeler.controllers;

public class DiagramMock {
    public static final String diagram1XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:gs=\"http://some-company/schema/bpmn/gs\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1\" targetNamespace=\"http://bpmn.io/schema/bpmn\">\n" +
            "  <bpmn:process id=\"Sample_Process\" isExecutable=\"false\">\n" +
            "    <bpmn:startEvent id=\"StartEvent\">\n" +
            "      <bpmn:outgoing>Flow_15f9e99</bpmn:outgoing>\n" +
            "    </bpmn:startEvent>\n" +
            "    <bpmn:scriptTask id=\"Script_Activity_1\" name=\"Log params\">\n" +
            "      <bpmn:extensionElements>\n" +
            "        <gs:groovyNode script=\"console.log(&#34;params&#34;);\" />\n" +
            "      </bpmn:extensionElements>\n" +
            "      <bpmn:incoming>Flow_15f9e99</bpmn:incoming>\n" +
            "      <bpmn:outgoing>Flow_1ri2164</bpmn:outgoing>\n" +
            "    </bpmn:scriptTask>\n" +
            "    <bpmn:sequenceFlow id=\"Flow_15f9e99\" sourceRef=\"StartEvent\" targetRef=\"Script_Activity_1\" />\n" +
            "    <bpmn:sequenceFlow id=\"Flow_1ri2164\" sourceRef=\"Script_Activity_1\" targetRef=\"Activity_2\" />\n" +
            "    <bpmn:scriptTask id=\"Activity_2\" name=\"for loop\">\n" +
            "      <bpmn:extensionElements>\n" +
            "        <gs:groovyNode script=\"for(i=0;i&#60;10;I++) {&#10;   console.log(i);&#10;}\" />\n" +
            "      </bpmn:extensionElements>\n" +
            "      <bpmn:incoming>Flow_1ri2164</bpmn:incoming>\n" +
            "      <bpmn:outgoing>Flow_04arqx5</bpmn:outgoing>\n" +
            "    </bpmn:scriptTask>\n" +
            "    <bpmn:intermediateThrowEvent id=\"Event_End\">\n" +
            "      <bpmn:incoming>Flow_04arqx5</bpmn:incoming>\n" +
            "    </bpmn:intermediateThrowEvent>\n" +
            "    <bpmn:sequenceFlow id=\"Flow_04arqx5\" sourceRef=\"Activity_2\" targetRef=\"Event_End\" />\n" +
            "  </bpmn:process>\n" +
            "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n" +
            "    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Sample_Process\">\n" +
            "      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent\">\n" +
            "        <dc:Bounds x=\"122\" y=\"82\" width=\"36\" height=\"36\" />\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape id=\"Activity_03c1nqv_di\" bpmnElement=\"Script_Activity_1\">\n" +
            "        <dc:Bounds x=\"210\" y=\"60\" width=\"100\" height=\"80\" />\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNEdge id=\"Flow_15f9e99_di\" bpmnElement=\"Flow_15f9e99\">\n" +
            "        <di:waypoint x=\"158\" y=\"100\" />\n" +
            "        <di:waypoint x=\"210\" y=\"100\" />\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge id=\"Flow_1ri2164_di\" bpmnElement=\"Flow_1ri2164\">\n" +
            "        <di:waypoint x=\"310\" y=\"100\" />\n" +
            "        <di:waypoint x=\"350\" y=\"100\" />\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNShape id=\"Activity_1ny49i7_di\" bpmnElement=\"Activity_2\">\n" +
            "        <dc:Bounds x=\"350\" y=\"60\" width=\"100\" height=\"80\" />\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape id=\"Event_18dhzli_di\" bpmnElement=\"Event_End\">\n" +
            "        <dc:Bounds x=\"492\" y=\"82\" width=\"36\" height=\"36\" />\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNEdge id=\"Flow_04arqx5_di\" bpmnElement=\"Flow_04arqx5\">\n" +
            "        <di:waypoint x=\"450\" y=\"100\" />\n" +
            "        <di:waypoint x=\"492\" y=\"100\" />\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "    </bpmndi:BPMNPlane>\n" +
            "  </bpmndi:BPMNDiagram>\n" +
            "</bpmn:definitions>\n";

    public static final String diagram2XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<bpmn:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:gs=\"http://some-company/schema/bpmn/gs\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1\" targetNamespace=\"http://bpmn.io/schema/bpmn\">\n" +
            "  <bpmn:process id=\"Process2\" isExecutable=\"false\">\n" +
            "    <bpmn:startEvent id=\"StartEvent\">\n" +
            "      <bpmn:outgoing>Flow_1jcjp6x</bpmn:outgoing>\n" +
            "    </bpmn:startEvent>\n" +
            "    <bpmn:scriptTask id=\"Activity2\" name=\"Succes\">\n" +
            "      <bpmn:extensionElements>\n" +
            "        <gs:groovyNode script=\"console.log(&#34;succes&#34;);\" />\n" +
            "      </bpmn:extensionElements>\n" +
            "      <bpmn:incoming>Flow_0wxnbe8</bpmn:incoming>\n" +
            "      <bpmn:outgoing>Flow_1dttdd5</bpmn:outgoing>\n" +
            "    </bpmn:scriptTask>\n" +
            "    <bpmn:scriptTask id=\"Activity_1mmn0gg\" name=\"Error\">\n" +
            "      <bpmn:extensionElements>\n" +
            "        <gs:groovyNode script=\"console.error(&#34;error&#34;);\" />\n" +
            "      </bpmn:extensionElements>\n" +
            "      <bpmn:incoming>Flow_0s0uyuj</bpmn:incoming>\n" +
            "      <bpmn:outgoing>Flow_034dibu</bpmn:outgoing>\n" +
            "    </bpmn:scriptTask>\n" +
            "    <bpmn:exclusiveGateway id=\"Gateway_1qvlp56\" name=\"Check\">\n" +
            "      <bpmn:incoming>Flow_1jcjp6x</bpmn:incoming>\n" +
            "      <bpmn:outgoing>Flow_0s0uyuj</bpmn:outgoing>\n" +
            "      <bpmn:outgoing>Flow_0wxnbe8</bpmn:outgoing>\n" +
            "    </bpmn:exclusiveGateway>\n" +
            "    <bpmn:sequenceFlow id=\"Flow_1jcjp6x\" sourceRef=\"StartEvent\" targetRef=\"Gateway_1qvlp56\" />\n" +
            "    <bpmn:sequenceFlow id=\"Flow_0s0uyuj\" sourceRef=\"Gateway_1qvlp56\" targetRef=\"Activity_1mmn0gg\" />\n" +
            "    <bpmn:sequenceFlow id=\"Flow_0wxnbe8\" sourceRef=\"Gateway_1qvlp56\" targetRef=\"Activity2\" />\n" +
            "    <bpmn:intermediateThrowEvent id=\"Event_05yf0vo\">\n" +
            "      <bpmn:incoming>Flow_034dibu</bpmn:incoming>\n" +
            "      <bpmn:incoming>Flow_1dttdd5</bpmn:incoming>\n" +
            "    </bpmn:intermediateThrowEvent>\n" +
            "    <bpmn:sequenceFlow id=\"Flow_034dibu\" sourceRef=\"Activity_1mmn0gg\" targetRef=\"Event_05yf0vo\" />\n" +
            "    <bpmn:sequenceFlow id=\"Flow_1dttdd5\" sourceRef=\"Activity2\" targetRef=\"Event_05yf0vo\" />\n" +
            "  </bpmn:process>\n" +
            "  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n" +
            "    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process2\">\n" +
            "      <bpmndi:BPMNShape id=\"_BPMNShape_StartEvent_2\" bpmnElement=\"StartEvent\">\n" +
            "        <dc:Bounds x=\"122\" y=\"132\" width=\"36\" height=\"36\" />\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape id=\"Activity_1yjh5zd_di\" bpmnElement=\"Activity2\">\n" +
            "        <dc:Bounds x=\"390\" y=\"200\" width=\"100\" height=\"80\" />\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape id=\"Activity_1mmn0gg_di\" bpmnElement=\"Activity_1mmn0gg\">\n" +
            "        <dc:Bounds x=\"390\" y=\"30\" width=\"100\" height=\"80\" />\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNShape id=\"Gateway_1qvlp56_di\" bpmnElement=\"Gateway_1qvlp56\" isMarkerVisible=\"true\">\n" +
            "        <dc:Bounds x=\"265\" y=\"125\" width=\"50\" height=\"50\" />\n" +
            "        <bpmndi:BPMNLabel>\n" +
            "          <dc:Bounds x=\"324\" y=\"143\" width=\"32\" height=\"14\" />\n" +
            "        </bpmndi:BPMNLabel>\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNEdge id=\"Flow_1jcjp6x_di\" bpmnElement=\"Flow_1jcjp6x\">\n" +
            "        <di:waypoint x=\"158\" y=\"150\" />\n" +
            "        <di:waypoint x=\"265\" y=\"150\" />\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge id=\"Flow_0s0uyuj_di\" bpmnElement=\"Flow_0s0uyuj\">\n" +
            "        <di:waypoint x=\"290\" y=\"125\" />\n" +
            "        <di:waypoint x=\"290\" y=\"70\" />\n" +
            "        <di:waypoint x=\"390\" y=\"70\" />\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge id=\"Flow_0wxnbe8_di\" bpmnElement=\"Flow_0wxnbe8\">\n" +
            "        <di:waypoint x=\"290\" y=\"175\" />\n" +
            "        <di:waypoint x=\"290\" y=\"240\" />\n" +
            "        <di:waypoint x=\"390\" y=\"240\" />\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNShape id=\"Event_05yf0vo_di\" bpmnElement=\"Event_05yf0vo\">\n" +
            "        <dc:Bounds x=\"652\" y=\"132\" width=\"36\" height=\"36\" />\n" +
            "      </bpmndi:BPMNShape>\n" +
            "      <bpmndi:BPMNEdge id=\"Flow_034dibu_di\" bpmnElement=\"Flow_034dibu\">\n" +
            "        <di:waypoint x=\"490\" y=\"70\" />\n" +
            "        <di:waypoint x=\"601\" y=\"70\" />\n" +
            "        <di:waypoint x=\"601\" y=\"150\" />\n" +
            "        <di:waypoint x=\"652\" y=\"150\" />\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "      <bpmndi:BPMNEdge id=\"Flow_1dttdd5_di\" bpmnElement=\"Flow_1dttdd5\">\n" +
            "        <di:waypoint x=\"490\" y=\"240\" />\n" +
            "        <di:waypoint x=\"601\" y=\"240\" />\n" +
            "        <di:waypoint x=\"601\" y=\"150\" />\n" +
            "        <di:waypoint x=\"652\" y=\"150\" />\n" +
            "      </bpmndi:BPMNEdge>\n" +
            "    </bpmndi:BPMNPlane>\n" +
            "  </bpmndi:BPMNDiagram>\n" +
            "</bpmn:definitions>\n";
}
