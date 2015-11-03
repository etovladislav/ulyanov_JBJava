<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main-template.ftl"/>
<#macro m_body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-8 col-md-offset-2" id="registration-container">
            <@sf.form action="/registration" method="post" cssId="form-reg" modelAttribute="userform">
                <div class="col-lg-5 col-lg-offset-1">
                    <h3>Registration</h3>
                </div>
                <div class="col-lg-5">

                    <label for="login">Логин</label><@sf.errors path="username" cssClass="error"/>
                    <@sf.input path="username" id="username" cssClass="form-control" placeholder="Логин"/>
                    <div id="div_username" style="color:red;"></div>
                    <label for="name">Как вас зовут?</label> <@sf.errors path="firstname" cssClass="error"/>
                    <@sf.input path="firstname" id="firstname" cssClass="form-control" placeholder="Имя"/>

                    <label for="lastname">Тут фамилия</label><@sf.errors path="lastname" cssClass="error"/>
                    <@sf.input path="lastname" id="lastname" cssClass="form-control" placeholder="Фамилия"/>

                    <label>Ваш пол</label>

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

                    <label for="surname">Город</label>
                    <@sf.input path="city" id="city" cssClass="form-control" placeholder="Фамилия"/>

                    <label for="password1">Пароль</label><@sf.errors path="password" cssClass="error"/>
                    <@sf.input path="password" type="password" id="password" cssClass="form-control" placeholder="Пароль"/>

                    <div class="checkbox">
                        <label>
                            <@sf.checkbox path = "openAccount" value="true" id="openAccount"/> Закрытый аккаунт
                        </label>
                    </div>
                    <button type="submit" id="button-reg" class="btn btn-block btn-primary">Зарегистрироваться</button>
                </div>
            </@sf.form>
        </div>
    </div>
</div>
<script src="/js/validate.js"></script>
</#macro>
<@main title="Registration"/>