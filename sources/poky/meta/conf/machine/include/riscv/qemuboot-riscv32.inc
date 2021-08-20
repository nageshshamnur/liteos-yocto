#@TYPE: Machine
#@NAME: QEMU RISCV32 machine
#@DESCRIPTION: Machine configuration for running an RISCV32 system on QEMU

IMAGE_CLASSES += "qemuboot"

KERNEL_IMAGETYPE = "bzImage"
QB_DEFAULT_KERNEL = "bzImage"

SERIAL_CONSOLES ?= "ttyS0"
SERIAL_CONSOLES_CHECK = "${SERIAL_CONSOLES}"

# qemuboot options
IMAGE_CLASSES += "qemuboot"
QB_SYSTEM_NAME = "qemu-system-riscv32"
QB_MACHINE = "-machine virt"
QB_CPU = "-cpu riscv32nf"
QB_MEM = "-m 128"
QB_KERNEL_CMDLINE_APPEND = "root=dev/vda or console=ttyS0"
