  <meta name="layout" content="main"/>
   <div class="breadCrumbs"></div>
  <div class="pageTitle">Home</div>
  <div class="mainContent" style="display:none;">
      <div style="margin-left:100px;">
          <g:form action="index" controller="home">
            Mote: <g:select optionKey="id" name="moteId" optionValue="name"  from="${motes}" value="${mote}"/>
            <br/>
             Max Results:<g:textField name="max" value="${max}"/>
            <br/>
              <g:submitButton name="submit" value="submit">Submit</g:submitButton>
          </g:form>
      </div>
    <div style="margin-left:50px;">
      <h1>
          ${mote?.name}
      </h1>
          <g:each in="${sensors}" var="sensor">
               <div>
                   <h2>${sensor.key.sid} - ${sensor.key.name} - ${sensor.key.sensortype}</h2>
                   <g:each in="${sensor.value}" var="state">
                       <ul><li><g:formatDate dateStyle="" date="${state.timeStamp}" format="yyyy-MM-dd HH:mm:ss"/>- ${state.value}</li></ul>
                   </g:each>
              </div>


          </g:each>
    </div>
</div>