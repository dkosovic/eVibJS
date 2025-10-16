(function(){var P$=Clazz.newPackage("javax.xml.bind"),I$=[];
/*c*/var C$=Clazz.newClass(P$, "JAXBIntrospector");

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

Clazz.newMeth(C$, 'getValue$O',  function (jaxbElement) {
if (Clazz.instanceOf(jaxbElement, "javax.xml.bind.JAXBElement")) {
return (jaxbElement).getValue$();
} else {
return jaxbElement;
}}, 1);

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-09-04 12:37:39 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7
