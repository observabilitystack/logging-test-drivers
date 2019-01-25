import random
from random import randrange as ri
from os import environ as env
import time
import datetime

def sleep():
    """sleep for a while to log with the frequency set via the environment variable LOG_LINES_PER_MINUTE"""
    time.sleep( 120 * random.random() / int(env['LOG_LINES_PER_MINUTE']) )

def apache_unified_ts():
    return datetime.datetime.fromtimestamp(time.time()).strftime('%d/%b/%Y:%H:%M:%S +0100')

def ip_address():
    return "%s.%s.%s.%s" % (20 + ri(100) + 100*ri(2), 1 + ri(254), 1 + ri(254), 1 + ri(254))

def response_size():
    return str(random.randrange(1000,10000))

def http_path():
    SUB_DIRS = ["", "blog/", "technology", "career", "services", "about-us/"]
    RESOURCES = ["index.html", "check.js", "styles.css", "logo.png", "header.html", "footer.html"]
    return "/%s%s" % (random.choice(SUB_DIRS), random.choice(RESOURCES))

def apache_unified_log_line():
    APACHE_UNIFIED = "%s - - [%s] \"GET %s HTTP/1.0\" 200 %s"
    return (APACHE_UNIFIED % (ip_address(), apache_unified_ts(), http_path(), response_size()))

def get_output_writer():
    if ('LOG_TO_FILE' in env):
        def output_logfile(line):
            f=open(env['LOG_TO_FILE'], "a")
            print(line, file=f)
            f.close()
        return output_logfile

    def output_stdout(line):
        print(line)
    return output_stdout

while(True):
    output = get_output_writer()
    output(apache_unified_log_line())
    sleep()
