<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>
<#macro m_body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-8 col-md-offset-2" id="registration-container">
            <@sf.form action="/settings" method="post" cssId="form-reg" modelAttribute="userform">
                <div class="col-lg-5 col-lg-offset-1">
                    <h3>Настройки</h3>
                </div>
                <div class="col-lg-5">
                    <label for="name">Вы решили зименить имя?</label> <@sf.errors path="firstname" cssClass="error"/>
                    <@sf.input path="firstname" id="firstname" cssClass="form-control" value="${user.firstname}" placeholder="Имя"/>

                    <label for="lastname">Или фамилию?</label><@sf.errors path="lastname" cssClass="error"/>
                    <@sf.input path="lastname" id="lastname" cssClass="form-control" value="${user.lastname}" placeholder="Фамилия"/>

                    <label>А вдруг</label>

                    <div class="radio">
                        <label>
                            <@sf.radiobutton path="sex" value="0"/>Мужской
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <@sf.radiobutton path="sex" value="1"/>Женский
                        </label>
                    </div>
                    <label for="surname">Переехал</label>
                    <@sf.input path="city" id="city" cssClass="form-control" value="${user.city}" placeholder="Фамилия"/>

                    <label for="surname">Выбери аватарку ;(</label><br/>
                    <@sf.radiobutton path="avatar" value="1"/>Котик <br/>
                    <@sf.radiobutton path="avatar" value="2"/>Собачка <br/>
                    <@sf.radiobutton path="avatar" value="3"/>Енотик <br/>
                    <@sf.radiobutton path="avatar" value="4"/>Андрей <br/>
                    <button type="submit" id="button-reg" class="btn btn-block btn-primary">Изменить</button>
                </div>
            </@sf.form>
        </div>
    </div>
</div>
</#macro>
<@main title="Registration"/>