(function(){var P$=Clazz.newPackage("sun.misc"),I$=[];
/*c*/var C$=Clazz.newClass(P$, "FIFOQueueEnumerator", null, null, 'java.util.Enumeration');

C$.$clinit$=2;

Clazz.newMeth(C$, '$init$', function () {
},1);

C$.$fields$=[['O',['queue','sun.misc.Queue','cursor','sun.misc.QueueElement']]]

Clazz.newMeth(C$, 'c$$sun_misc_Queue',  function (q) {
;C$.$init$.apply(this);
this.queue=q;
this.cursor=q.tail;
}, 1);

Clazz.newMeth(C$, 'hasMoreElements$',  function () {
return (this.cursor != null );
});

Clazz.newMeth(C$, 'nextElement$',  function () {
{
if (this.cursor != null ) {
var result=this.cursor;
this.cursor=this.cursor.prev;
return result.obj;
}}throw Clazz.new_(Clazz.load('java.util.NoSuchElementException').c$$S,["FIFOQueueEnumerator"]);
});

Clazz.newMeth(C$);
})();
;Clazz.setTVer('5.0.1-v7');//Created 2025-09-04 12:37:59 Java2ScriptVisitor version 5.0.1-v7 net.sf.j2s.core.jar version 5.0.1-v7
