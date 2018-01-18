from django.http import HttpResponse, Http404
from django.template import Context
from django.template.loader import get_template
from django.shortcuts import render_to_response
import datetime
from app.models import Publisher

def hello(request):
    return HttpResponse("Hello World")

def datetime1(request):
    now = datetime.datetime.now()
    html = "<html><body>It is now %s.</body></html>" % now
    return HttpResponse(html)

def datetime2(request):
    now = datetime.datetime.now()
    t = get_template('datetime.html')
    html = t.render(Context({'current_date': now}))
    return HttpResponse(html)

def datetime3(request):
    now = datetime.datetime.now()
    return render_to_response('datetime.html', Context({'current_date': now}))

def datetime4(request):
    current_date = datetime.datetime.now()
    return render_to_response('datetime.html', locals())

def hours_ahead(request, offset):
    try:
        hour_offset = int(offset)
    except ValueError:
        raise Http404()
    next_time = datetime.datetime.now() + datetime.timedelta(hours=hour_offset)
    return render_to_response('hours_ahead.html', locals())

def list_publisher(request, name=''):
    if(name == ''):
        s = Publisher.objects.all()
    else:
        s = Publisher.objects.filter(name__contains=name)
    strResponse = ''
    if len(s) == 0:
        strResponse = 'No Result'
    else:
        for item in s:
            strResponse += item.name + '\n'
    return HttpResponse(strResponse)
