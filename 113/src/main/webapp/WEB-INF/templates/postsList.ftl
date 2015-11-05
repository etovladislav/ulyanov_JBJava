<#if posts?has_content>
    <#list posts as post>
    <div class="row album-item">
        <div class="header-item">
            <img src="${post.sendUser.avatar}" class="img-circle" height="30" width="30" alt=""/>
            <a href="/${post.sendUser.username}">${post.sendUser.username}</a>
        </div>
        <div class="col-md-10 col-sm-9">
            <div class="row">
                <div class="col-xs-12">
                    <div class="post-text">
                        <p>${post.text}</p>
                    </div>
                    <small style="font-family:courier,'new courier'; margin-left:10px;"
                           class="text-muted">${post.date}</small>
                    <#if page = post.user.id>
                        <button type="button" onclick="deletePost(${post.id})" class="btn btn-default btn-sm"><i
                                class="fa fa-trash-o" style="color:red;"></i>
                            Delete post
                        </button>
                    </#if>
                </div>
            </div>
            <br>
        </div>
    </div>
    </#list>
<#else>
Здесь пока ничего не писали
</#if>