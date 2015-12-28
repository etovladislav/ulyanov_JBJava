<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">
    <div class="row">
        <form class="form-signin" role="form" action="/login/process" method="post">
            <h2 class="form-signin-heading">Please sign in</h2>

            <div class="error">
                <#if error??>
                    Invalid username or password
                </#if>
            </div>
            <form action="/login/process/" method="post">
                <input type="text" class="form-control" name="username" placeholder="Email address" required autofocus>
                <input type="password" class="form-control" name="password" placeholder="Password" required>
                <button class="btn  btn-success btn-block" type="submit">Sign in</button>
            </form>
        </form>
    </div>
</div>
</#macro>
<@main title="Login"/>
