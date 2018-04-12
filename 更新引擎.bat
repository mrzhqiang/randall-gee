@echo off
echo 	======================================================
echo 	欢迎使用 randall-gee 更新引擎脚本！请仔细阅读以下说明：	
echo 	======================================================

pause

echo 	====================================================================
echo 	1. 请从 http://www.geem2.com 下载最新引擎版本，并解压在【A】目录下。	
echo 	——————————————————————————————————
echo 	提示：【A】目录可以是任何目录，通常应该手动创建，并记住目录路径。
echo 	====================================================================
echo 	2. 请确认，randall-gee 仓库位于 F 盘根目录。
echo 	——————————————————————
echo 	提示：如果不是，请修改此脚本中的【F:\randall-gee】为当前目录路径（比如 D:\randall-gee）。
echo 	====================================================================
echo 	3. 请将此脚本文件复制到【A】目录下，并确保目标服务器已停止服务！
echo 	————————————————————————————————
echo 	注意：以上条件全部符合，才可以继续执行，否则，请直接关闭此窗口！
echo 	====================================================================
pause

set WSDir=F:\randall-gee

Copy Mir200\M2Server.exe %WSDir%\Mir200\ /y
Copy DBServer\DBServer.exe %WSDir%\DBServer\ /y
Copy LogServer\LogDataServer.exe %WSDir%\LogServer\ /y
Copy LoginGate\LoginGate.exe %WSDir%\LoginGate\ /y
Copy LoginSrv\LoginSrv.exe %WSDir%\LoginSrv\ /y
Copy RunGate\RunGate.exe %WSDir%\RunGate\ /y
Copy SelGate\SelGate.exe %WSDir%\SelGate\ /y
Copy GameCenter.exe %WSDir%\GameCenter.exe /y

echo 	====================================================================
echo 	引擎文件已更新完成. . .
echo 	————————————
echo 	如果提示失败，可能是权限不够，或者复制时源文件并不存在！
echo 	————————————————————————————
echo 	请确保拥有读写文件权限，并且源文件未被其他软件占用或删除！
echo 	—————————————————————————————
echo 	即将退出...
echo 	====================================================================
pause