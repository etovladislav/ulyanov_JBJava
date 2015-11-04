<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">
    <div class="row profile">
        <div class="col-md-3">
            <div class="profile-sidebar">
                <!-- SIDEBAR USERPIC -->
                <div class="profile-userpic">
                    <img src="${user.avatar}"
                         class="img-responsive" alt="">
                </div>
                <!-- END SIDEBAR USERPIC -->
                <!-- SIDEBAR USER TITLE -->
                <div class="profile-usertitle">
                    <div class="profile-usertitle-name">
                    ${user.firstname} ${user.lastname}
                    </div>
                    <div class="profile-usertitle-job">
                    ${user.city}
                    </div>
                    <div id="username">
                    ${user.username}
                    </div>
                </div>
                <div class="profile-usermenu">
                    <ul class="nav">
                        <li class="active">
                            <a href="#" target="_blank">
                                <i class="fa fa-rss"></i>
                                Posts <#assign postSize = user.getPosts()?size>
                            ${postSize} </a>
                        </li>
                    </ul>
                </div>
                <!-- END MENU -->
            </div>
        </div>
        <div class="col-md-9 container-page" style="background-color:#ffffff;padding:20px; min-height:334px;">
            <#if auth??>
                <textarea class="form-control" id="js-post-text" rows="3"
                          style="resize: none; margin-bottom: 10px"></textarea>
                <button class="btn btn-primary pull-right" id="js-sendpost">Отправить</button>
            </#if>
            <#if auth??>
                <div id="posts-user">

                </div>
            <#else>
                <a href="/registration">Зарегестрируйтесь</a>, чтобы посмотреть.
            </#if>
        </div>
        <!--/stories-->
        <div style="clear: both;"></div>
    </div>
</div>
</div>
</div>
<script src="/js/script.js"></script>
</#macro>
<@main title="Main page"/>
