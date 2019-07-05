import requests
import re
import json
import time

def get_one_page(url):
    try:
        headers={'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) \
                 AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36'}
        response=requests.get(url, headers=headers)
        if response.status_code==200:
            return response.text
        return None
    except requests.RequestException:
        print("Fail")

def parse_one_page(html):
    pattern=re.compile('<dd>.*?board-index.*?>(.*?)</i>.*?data-src="(.*?)".*?name.*?a.*?>(.*?)</a>.*?releasetime.*?>(.*?)</p>.*?score.*?integer">(.*?)</i>.*?fraction">(.*?)</i>.*?</dd>', re.S)
    result=re.findall(pattern, html)
    for item in result:
        yield {"index": item[0], "movie_name": item[2],\
                "pic": item[1], "release": item[3],\
                "score": item[4]+item[5]}

def write_to_file(result):
    with open ("yyy.txt","a") as f:
        f.write(json.dumps(result, ensure_ascii=False)+'\n')

def main(offset):
    url="http://vip.stock.finance.sina.com.cn/q/go.php/vinvestconsult/kind/dzjy/index.?offset={}".format(offset)
    html=get_one_page(url)
    result=parse_one_page(html)
    for i in result:
        write_to_file(i)

if __name__=='__main__':
    for i in range(10):
        main(offset=i*10)
        time.sleep(1)
