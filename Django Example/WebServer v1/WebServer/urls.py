from django.conf.urls import patterns, include, url
from django.contrib import admin
from app.views import hello, datetime1, datetime2, datetime3, datetime4, hours_ahead

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'WebServer.views.home', name='home'),
    # url(r'^blog/', include('blog.urls')),

    url(r'^admin/', include(admin.site.urls)),
    url(r'^hello/$', hello),
    url(r'^time1/$', datetime1),
    url(r'^time2/$', datetime2),
    url(r'^time3/$', datetime3),
    url(r'^time4/$', datetime4),
    url(r'^time/plus/(\d{1,2})/$', hours_ahead),
)
