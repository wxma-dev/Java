
测试:

只有内网的情况
只有外网的情况

内外网都有的情况

3个以上网的情况



++add 功能：
关闭对应的cmd的窗口的时候，就以为这要关闭所有的网络呗? => 没有实现
现在感觉，就是挺顿的时间长了，等不了                   => 实现



--------------------------
开发整体架构：
while( 1 )
{
    1.若内外网络都连接状态，则无需侦测；删除默认路由的处理。
    2.若只连了内网，则需要侦测是否有外网wifi连接，
                                               有则重新断开、先连内网、再连外网，再删除默认路由的处理。
                                               无则continue；
    3.若只连了外网，则需要侦测是否有内网wifi连接，
                                               有则重新断开、先连内网、再连外网；删除默认路由的处理。
                                               无则continue；
    4.若内外网都没有连接，则需要侦测，
                                    内外网wifi都有，则有则重新断开、先连内网、再连外网；删除默认路由的处理。
                                    只有内网，连接内网；[不做]删除默认路由的处理。
                                    只有外网，连接外网。[不做]删除默认路由的处理。
    sleep( 1 )
}

外网可以设置多个wifi的配置，优先级，按顺序依次。

获取配置的内容，作为一个类

内网网的连接情况接口：内外网  0
                      内网    1
                      外网    2
                      无      3

侦测wifi的情况接口：  内外网  0
                      内网    1
                      外网    2
                      无      3

网络处理接口：    内外网 断开，先连接内网，再联外网。

删除默认路由的处理接口：

---------------------------

C:\Users\Administrator>netsh wlan disconnect interface="无线网络连接 2" 
已成功完成接口“无线网络连接 2”的断开连接请求。

C:\Users\Administrator>netsh wlan disconnect interface="无线网络连接" 
已成功完成接口“无线网络连接”的断开连接请求。

C:\Users\Administrator>netsh wlan connect interface="无线网络连接" name=xx
已成功完成连接请求。

C:\Users\Administrator>netsh wlan connect interface="无线网络连接 2" name=xx ssid=xx
已成功完成连接请求。

=> name  ssid 加不加"号无所谓
C:\Users\Administrator>netsh wlan connect interface="无线网络连接 2" name="xx" ssid="xx"
已成功完成连接请求。


netsh wlan connect ssid=YOURSSID name=PROFILENAME interface="WIRELESS NETWORK CONNECTION"

netsh wlan disconnect interface="无线网络连接"


显示网卡连接了那个网络
netsh wlan show interface

现实网卡侦测到的网络
netsh wlan show networks

断开网络连接
>netsh wlan disconnect interface="无线网络连接 2"

连接网络
>netsh wlan connect interface="无线网络连接 2" ssid="xx"



